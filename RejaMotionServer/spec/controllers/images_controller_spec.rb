require 'spec_helper'

describe ImagesController do
  fixtures :images

  describe 'GET #index' do
    context 'when access to route' do
      before do
        get :index
      end
      it 'responds successfully with an HTTP 200 status code' do
        expect(response).to be_success
      end
      it 'renders the index template' do
        expect(response).to render_template('index')
      end
      it 'loads all of the images into @image_list' do
        image1, image2 = Image.find(:all)
        expect(assigns(:image_list)).to match_array([image1, image2])
      end
    end
  end

  describe 'GET #show' do
    context 'when access to exsting image id' do
      before do
        get :show, :id => 1
      end
      it "responds successfully with an HTTP 200 status code" do
        expect(response).to be_success
      end
      it "renders the show templage" do
        expect(response).to render_template("show")
      end
    end

    context "when access to not exsting image id" do
      before do
        get :show, :id => 9999
      end
      it "renders the notfound template" do
        expect(response) render_template("notfound")
      end
    end
  end

end
