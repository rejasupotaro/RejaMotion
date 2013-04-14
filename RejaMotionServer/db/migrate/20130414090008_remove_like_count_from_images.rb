class RemoveLikeCountFromImages < ActiveRecord::Migration
  def up
    remove_column :images, :like_count
  end

  def down
    add_column :images, :like_count, :int
  end
end
