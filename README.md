# flyway-3362
> [flyway/flyway#3362](https://github.com/flyway/flyway/issues/3362#issuecomment-1032676069)

## Requirements
- [JDK 8 or 11](https://aws.amazon.com/corretto) (not newer!)
- [sbt 1.x](https://www.scala-sbt.org/)
- [Docker](https://docs.docker.com/get-docker/)

## Reproduce

1. Start a mysql server on port `33066` (in case you are already running another one)
   ```shell
   docker run --rm -it -d\
    --name demo-mysql\
    -p 33066:3306\
    -e "MYSQL_RANDOM_ROOT_PASSWORD=true"\
    -e "MYSQL_USER=flyway"\
    -e "MYSQL_PASSWORD=3362"\
    -e "MYSQL_DATABASE=demo"\
    mysql:8
   ```

2. Start the application (make sure that Java 8 or 11 is used)
   ```shell
   sbt run
   ```

3. Open the app in the browser: http://localhost:9000/\
   The project will be compiled and then throw an exception.

## Downgrade Flyway version
When downgrading flyway to `8.2.0`, the same setup works again.

1. Edit `build.sbt` and change the [flyway-play](https://github.com/flyway/flyway-play) version from `7.19.0` to `7.17.0`
   ```text
   "org.flywaydb" %% "flyway-play" % "7.17.0"
                                      ^^^^^^
   ```
2. Start the project again
3. Open http://localhost:9000/ in a browser, now everything works fine