require 'zipruby'

class ImagesController < ApplicationController

  def index
    #@image_list = Image.find(:all, :order => 'created_at, id desc', :limit => 6)
    @image_list = Image.find(:all).sample(6)
    @image_text = "Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit."

    render 'images/index'
  end

  def show
    @image = Image.where("id = ?", params[:id]).first
    @image_text = "Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit."

    render 'images/show'
  end

  def upload
    image_title = params[:image_title]
    content = params[:content]
    zipfile = "out.zip"
    zipfile_path = Rails.root.to_s + "/tmp/" + zipfile
    File.binwrite(zipfile_path, content.tempfile.read)

    upload_time = Time.now
    upload_time_unix = upload_time.to_i
    image_url = '/images/' + upload_time_unix.to_s + '.gif'
    output_path = Rails.root.to_s + '/public' + image_url

    zip_to_gif(zipfile_path, output_path, params[:delay])

    Image.create(
      :title      => image_title,
      :url        => image_url)

    render :json => {"result" => "ok"}
  end

  def zip_to_gif(src_path, out_path, delay)
    image_path_array = Array.new
    tmpout_path = Rails.root.to_s + "/tmp/out/"
    Zip::Archive.open(src_path.to_s) do |archives|
      archives.each do |archive|
        FileUtils.makedirs(tmpout_path)
        unless archive.directory?
          image_path = tmpout_path + archive.name
          File.open(image_path, "w+b") do |file|
            file.print(archive.read)
          end
          image_path_array.push(image_path)
        end
      end
    end

    convert_command = convert_command_builder(image_path_array, out_path, delay)
    system(convert_command)
    remove_command = 'rm -rf ' + Rails.root.to_s + '/tmp/out/*'
    system(remove_command)
  end

  def convert_command_builder(image_path_array, out_path, delay, max_size = 600)
    resize_option = '-resize ' + max_size.to_s + 'x' + max_size.to_s
    delay_option = '-delay ' + delay.to_s

    image_list_string = '';
    image_path_array.each do |image_path|
      image_list_string << image_path.to_s << ' '
    end

    return 'convert ' + resize_option + ' ' + delay_option + ' ' + image_list_string + out_path.to_s
  end

end
