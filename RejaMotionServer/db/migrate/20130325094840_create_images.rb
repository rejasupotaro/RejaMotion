class CreateImages < ActiveRecord::Migration
  def change
    create_table :images do |t|
      t.string :title
      t.string :url
      t.integer :like_count

      t.timestamps
    end
  end
end
