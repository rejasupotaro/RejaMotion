class ImagesController < ApplicationController

  def index
    @image_list = Image.find(:all).sample(6)

    @image_url = @image_list[0].url
    @image_title = @image_list[0].title
    @image_text = "Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit."

    render 'images/index'
  end

end
