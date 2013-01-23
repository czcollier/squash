resolvers += "Gamlor-Repo" at "https://github.com/gamlerhart/gamlor-mvn/raw/master/snapshots"

resolvers += "Gamlor-Repo-Noraw" at "https://raw.github.com/gamlerhart/gamlor-mvn/master/snapshots"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.typesafe.akka" % "akka-actor" % "2.0.5"

libraryDependencies += "info.gamlor.akkaasync"  %% "akka-dbclient" % "1.0-SNAPSHOT"

libraryDependencies += "org.adbcj" % "adbcj-api" % "0.5.0-SNAPSHOT"

libraryDependencies += "org.adbcj" % "mysql-async-driver" % "0.5.0SNAPSHOT"
