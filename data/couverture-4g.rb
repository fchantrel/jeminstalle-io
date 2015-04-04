input {
   file {
       path => [ "/home/fchantrel/git/jeminstalle-io/data/couverture-4g-ok2.csv" ]
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
        columns => ['codedepartement',
          'nomdepartement',
          'coderegion',
          'couvorange',
          'couvsfr',
          'couvbouygues',
          'couvfree',
          'surforange',
          'surfsfr',
          'surfbouygues',
          'surffree'
          ]
        separator => ";"
        remove_field => ['message','@version', '@timestamp', 'host', 'path','column12' ]
    }

    mutate {
      convert => [ "couvorange", "float" ]
      convert => [ "couvsfr", "float" ]
      convert => [ "couvbouygues", "float" ]
      convert => [ "couvfree", "float" ]
      convert => [ "surforange", "float" ]
      convert => [ "surfsfr", "float" ]
      convert => [ "surfbouygues", "float" ]
      convert => [ "surffree", "float" ]
    }
  }

}

output {

  elasticsearch {
    host => localhost
    index => "jeminstalle"
    index_type => "couverture_4g"
    cluster => "cluster-dev-fch-1.4.4"
  }

  #stdout { 
  #    codec => rubydebug
  #}
}
