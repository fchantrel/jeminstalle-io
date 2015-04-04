input {
   file {
       path => [ "/home/fchantrel/git/jeminstalle-io/data/revenu_moyen_par_commune_2011_ok2.csv" ]
       start_position => "beginning"
       sincedb_path => "/dev/null"
   }
}

filter {

  if([message] =~ "Code géographique") {
    drop { }
  } 

  else {

    csv {
        columns => ['codeinsee',
          'nomcommune',
          'a',
          'b',
          'c',
          'd',
          'e',
          'f',
          'g',
          'revenu',
          'classement']
        separator => ";"
        remove_field => ['message','@version', '@timestamp', 'host', 'path', 'a','b','c','d','e','f','g']
    }

    mutate {
      convert => [ "revenu", "integer" ]
      convert => [ "classement", "integer"]
    }
  }

}

output {

   elasticsearch {
    host => localhost
    index => "jeminstalle"
    index_type => "revenu_moyen"
    cluster => "cluster-dev-fch-1.4.4"
  }

  #stdout { 
  #    codec => rubydebug
  #}
}
