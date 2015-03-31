input {
   file {
       path => [ "./couverture-4g.csv" ]
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
          'code-region',
          'couv-orange',
          'couv-sfr',
          'couv-bouygues',
          'couv-free',
          'surf-orange',
          'surf-sfr',
          'surf-bouygues',
          'surf-free'
          ]
        separator => ";"
        remove_field => ['message','@version', '@timestamp', 'host', 'path','column12' ]
    }

    mutate {
      convert => [ "couv-orange", "float" ]
      convert => [ "couv-sfr", "float" ]
      convert => [ "couv-bouygues", "float" ]
      convert => [ "couv-free", "float" ]
      convert => [ "surf-orange", "float" ]
      convert => [ "surf-sfr", "float" ]
      convert => [ "surf-bouygues", "float" ]
      convert => [ "surf-free", "float" ]
    }
  }

}

output {

  #elasticsearch {
  #  host => localhost
  #  index => "jeminstalle"
  #  index_type => "couverture_4g"
  #  cluster => "cluster-dev-fch-1.4.4"
  #}

  stdout { 
      codec => rubydebug
  }
}