class ImagesController < ApplicationController
  def index
    @image_url = "http://rejamotion.com/images/gifs/88.gif"
    @image_title = "Frash Fish"
    @image_text = "Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit."
    render 'images/index'
  end
end
