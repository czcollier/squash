//resolvers += "Gamlor-Repo" at "https://github.com/gamlerhart/gamlor-mvn/raw/master/snapshots"

resolvers += "Gamlor-Repo-Noraw" at "https://raw.github.com/gamlerhart/gamlor-mvn/master/snapshots"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
    "com.typesafe.akka"     %  "akka-actor"                 % "2.0.5",
    "com.typesafe.akka"     %  "akka-slf4j"                 % "2.0.5",
    "info.gamlor.akkaasync" %% "akka-dbclient"              % "1.0-SNAPSHOT",
    "org.adbcj"             %  "adbcj-api"                  % "0.5.0-SNAPSHOT",
    "org.adbcj"             %  "mysql-async-driver"         % "0.5.0-SNAPSHOT",
    "ch.qos.logback"        %  "logback-classic"            % "1.0.0" ,
    "org.slf4j"             %  "slf4j-api"                  % "1.6.1")

checksums in update := Nil
