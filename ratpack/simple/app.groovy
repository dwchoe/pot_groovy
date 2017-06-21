@Grab('io.ratpack:ratpack-groovy:1.4.0-rc-2')

import static ratpack.groovy.Groovy.ratpack

ratpack {
  serverConfig {
    development true
  }
  handlers {
    get {
      render "hello world"
    }

    get("ping") {
      render "ping"
    }
 
    get("name/:name") {
      render "hello world, $pathTokens.name"
    }
   
    path("status") {
      byMethod {
        get {
          render "status"
        }
      }
    }
  }
}
