require 'zipruby'

module ImagesHelper

  def generate_image_file_name
    upload_time = Time.now
    upload_time_unix = upload_time.to_i
    upload_time_unix.to_s + ".gif"
  end

  def zip_to_gif(content, zipfile_path, out_path, delay)
    File.binwrite(zipfile_path, content.tempfile.read)

    image_path_array = Array.new
    tmpout_path = Rails.root.to_s + "/tmp/out/"
    Zip::Archive.open(zipfile_path.to_s) do |archives|
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
