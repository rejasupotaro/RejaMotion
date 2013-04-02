require 'mysql2'

module MysqlClient
  def new_instance
    return Mysql2::Client.new(
      :host => "localhost",
      :username => "betterflow",
      :password => "hogehoge",
      :database => "rejamotion")
  end

  module_function :new_instance
end
