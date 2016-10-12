Contributing
============

There are several ways to contribute:
* Report an issue
* Create a Pull Request

Create a Pull Request
---------------------

The best way to contribute to the project is to create a pull request.

Fork, then clone the repo:
     
     git clone git://github.com/infinitest/infinitest.git


Setup your environement see below

Make Sure the test pass
     
     mvn clean install
     
Make your change. Add tests for your change. Make the tests pass:

     mvn clean install
     
Push to your fork and [submit a pull request][pr].

[pr]: https://github.com/infinitest/infinitest/compare/

At this point you're waiting on us. We like to at least comment on pull requests
within three business days. We may suggest
some changes or improvements or alternatives.

Some things that will increase the chance that your pull request is accepted:
* Write tests.
* Write a good commit message.


Developing infinitest
======================

Setup your dev environment
--------------------------
* You need [Maven](http://maven.apache.org/download.html)
* You need Eclipse or IntelliJ
* You need to import the infinitest maven projects into your project


Building the project
-------------------

You need [Maven](http://maven.apache.org/download.html). To run a reactor build in the repository root: 

	mvn clean install

This will compile, test and package all modules of the project in a single operation. 


Finding your way around
------------------------

`infinitest-lib` and `infinitest-runner` are included in every plugin. `infinitest-intellij` is the IntelliJ plugin, while `infinitest-eclipse` is the eclipse plugin.

`testWorkspace` is a collection of sample projects that we use for exploratory testing. If you find something in the wild that makes Infinitest break, it's a good idea to reproduce it in testWorkspace, fix it, and then try it again to be sure you've really fixed it.


Running and Debugging Infinitest for Eclipse
--------------------------------------------

Once you have imported the infinitest maven projects inside eclipse you can run or debug infinitest for eclipse by:
* Right-click `infinitest-eclipse/plugin.xml` -> Open With -> Plug-in Manifest Editor
* In the "Overview" Tab -> Launch/Debug an Eclipse application

*Note*: While you can use Infinitest to test Infinitest from eclipse, some weird things happen when you change anything in the `infinitest-runner` project, because that project is actually used to run the tests, so any changes you make may conflict with the classes in whatever version of the plugin you have installed. As a result, we try to keep `infinitest-runner` as thin as we can get it.



Publishing a release
--------------------

When you finish something, release it. Also, make sure you don't push anything to github that's not in a releasable state. It's OK to temporarily disable stuff...just make sure that work in progress isn't breaking anything else.

The `release.sh` script will build a new version of the plugin, incrementing the version number, and copy it to the server hosting the update site. This copy will fail if Ben hasn't added your public ssh key to the server (See above). We like developers to publish a release after implementing every feature.

Running `release.sh` copies the plugin to the experimental [update site](http://update.improvingworks.com/experimental). It's suggested that you publish and then test the plugin before promoting it to the main [update site](http://update.improvingworks.com). You do this using the `promote.sh` script.
