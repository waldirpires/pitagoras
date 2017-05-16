def downloaderPath = "./d/apps/internet/youtube-dl.exe"

new File(this.args[0]).eachLine { line ->
  println 'Downloading link ' + line + ' ...'
  def command = "$downloaderPath $line"
  println command
  println command.execute().text
}