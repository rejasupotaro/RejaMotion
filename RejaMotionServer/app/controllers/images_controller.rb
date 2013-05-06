class ImagesController < ApplicationController
  unit_action :admin_unit, :list

  include ImagesHelper

  def index
    invoke(:admin_unit, :index)

    @page = params[:p].present? ? params[:p].to_i : 1
    if @page <= 0
      redirect_to :action => "index"
      return
    end

    offset = 6 * (@page - 1)

    @image_list = Image.find(:all, :offset => offset, :order => 'created_at desc, id desc', :limit => 6)

    render 'images/index'
  end

  def show
    @image = Image.where("id = ?", params[:id]).first
    if @image.nil?
      render 'images/notfound' if @image.nil?
    elsif
      @image_text = "Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit."
      render 'images/show'
    end
  end

  def create
    upload
  end

  def upload
    image_title = params[:image_title]
    image_url = '/images/' + generate_image_file_name

    zipfile = "out.zip"
    zipfile_path = Rails.root.to_s + "/tmp/" + zipfile
    out_path = Rails.root.to_s + '/public' + image_url

    zip_to_gif(params[:content], zipfile_path, out_path, params[:delay])

    Image.create(
      :title      => image_title,
      :url        => image_url)

    render :json => {"result" => "ok"}
  end

end
