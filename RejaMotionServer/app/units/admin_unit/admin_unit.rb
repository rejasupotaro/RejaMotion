module AdminUnit
  include Chanko::Unit

  active_if do |context, options|
    true
  end

  scope(:controller) do
    function(:list) do
      @image_list = Image.find(:all)
      render :json => @image_list
    end

    function(:index) do
      @image_list = Image.find(:all)
      p @image_list
    end
  end
end
