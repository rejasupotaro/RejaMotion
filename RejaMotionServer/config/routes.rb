RejaMotionServer::Application.routes.draw do
  root :to => 'images#index'

  resources :images, :only => [:index, :show] do
    collection do
      get 'list'
    end
  end

  match 'api/upload' => 'images#upload'
end
