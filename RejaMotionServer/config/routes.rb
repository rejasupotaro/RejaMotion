RejaMotionServer::Application.routes.draw do
  root :to => 'images#index'
  resources :images, :only => [:index, :show]
  match 'api/upload' => 'images#upload'
end
