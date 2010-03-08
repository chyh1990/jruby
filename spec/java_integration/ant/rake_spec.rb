require File.expand_path('../../ant_spec_helper', __FILE__)
require 'rake'
require 'ant/rake'

describe Ant, "Rake helpers", :type => :ant do
  it "should set FileLists as task attributes by joining them with commas" do
    ant = Ant.new
    ant.property :name => "files", :value => FileList['*.*']
    ant.properties["files"].should =~ /,/
  end

end

describe Ant, "Rake #ant_task", :type => :ant do
  before :each do
    @app = Rake.application
    Rake.application = Rake::Application.new
  end

  after :each do
    Rake.application = @app
  end

  it "should create a Rake task whose body defines Ant tasks" do
    ant.properties.should_not include("foo")

    task :initial
    ant_task :ant => :initial do
      property :name => "foo", :value => "bar"
    end
    Rake::Task[:ant].should_not be_nil
    Rake::Task[:ant].prerequisites.should == ["initial"]
    Rake::Task[:ant].invoke

    ant.properties["foo"].should == "bar"
  end
end
