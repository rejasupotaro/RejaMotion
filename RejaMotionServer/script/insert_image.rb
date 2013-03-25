require 'mysql2'
require './script/mysql_client'

title = ARGV[0]
id = ARGV[1]
like_count = ARGV[2]

if title.nil? or id.nil?
  p "argv is not enough"
  exit()
end

if like_count.nil?
  like_count = 0
end

client = MysqlClient.new_instance

image_url = nil
insert_query = <<-SQL
  INSERT INTO images (title, url, like_count) VALUES ('#{title}', '/images/#{id}.gif', 0)
SQL
p insert_query
client.query(insert_query)
