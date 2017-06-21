@Grab('io.ratpack:ratpack-groovy:1.4.0-rc-2')

import static ratpack.groovy.Groovy.ratpack

ratpack {
  serverConfig {
    development true
  }
  handlers {
    // path: http://localhost:5050/
    get {
      render "hello world"
    }

    // path: http://localhost:5050/ping
    get("ping") {
      render "ping"
    }

    // path: http://localhost:5050/name/<any value> 
    get("name/:name") {
      render "hello world, $pathTokens.name"
    }
  
    // path: http://localhost:5050/status 
    path("status") {
      byMethod {
        get {
          render "status"
        }
      }
    }
  }
}
