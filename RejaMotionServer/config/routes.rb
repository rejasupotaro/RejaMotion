RejaMotionServer::Application.routes.draw do
  root :to => 'images#index'
  match 'images/:order' => 'images#index'
  resources :images, :only => [:index, :show]
  match 'api/upload' => 'images#upload'
end
