import groovy.io.FileType

def list = []

def dir = new File(".")
dir.eachFileRecurse (FileType.FILES) { file ->
  list << file
}

list.each {
  println it.path
}