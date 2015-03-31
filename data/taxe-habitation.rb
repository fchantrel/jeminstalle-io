input {
   file {
       path => [ "./taxe_habitation.csv" ]
       start_position => "beginning"
       sincedb_path => "/dev/null"
   }
}

filter {

  if([message] =~ "code") {
    drop { }
  } 

  else {

    csv {
        columns => ['code-departement',
          'nom-departement',
          'taux',
          'classement']
        separator => ";"
        remove_field => ['message','@version', '@timestamp', 'host', 'path']
    }

    mutate {
      convert => [ "taux", "float" ]
      convert => [ "classement", "integer"]
    }
  }

}

output {

  elasticsearch {
    host => localhost
    index => "jeminstalle"
    index_type => "taxe_habitation"
    cluster => "cluster-dev-fch-1.4.4"
  }

  stdout { 
      codec => rubydebug
  }
}