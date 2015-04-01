var jsonBasePath = '../../';
var springhost = '192.168.160.227';
var datapro = 'http://'+springhost+':8080/datapro/';

var activite;

var mapL;

    function getColor(d) {
        return d > 1 ? '#800026' :
            d > 0.8  ? '#BD0026' :
            d > 0.4  ? '#E31A1C' :
            d > 0.2  ? '#FC4E2A' :
            d > 0.1   ? '#FD8D3C' :
            d > 0.05   ? '#FEB24C' :
            d > 0.001   ? '#FED976' :
            d > 0 ?          '#FFEDA0':
                '#FFFFF0';
    }

    function style(feature) {
        return {
            fillColor: getColor(feature.properties.ratio),
            weight: 2,
            opacity: 1,
            color: 'white',
            dashArray: '3',
            fillOpacity: 0.5
        };
    }

    // Controls

    var info = L.control();

    function initMap() {

        // ===== Les layers du début ========

        // Fond de carte

        L.tileLayer('https://{s}.tiles.mapbox.com/v3/{id}/{z}/{x}/{y}.png', {
            maxZoom: 18,
            attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, ' +
                '<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
                'Imagery © <a href="http://mapbox.com">Mapbox</a>',
            id: 'examples.map-20v6611k'
        }).addTo(mapL);

        info.onAdd = function (map) {
            this._div = L.DomUtil.create('div', 'info'); // create a div with a class "info"
            this.update();
            return this._div;
        };

        // method that we will use to update the control based on feature properties passed
        info.update = function (props) {
            this._div.innerHTML = '<h4>Densité'+(activite.length>0 ? ' pour '+activite:' de la zone')+'</h4>' +  (props ?
                '<b>' + props.nom + '</b><br />' + props.ratio + ' (/1000 hbts).'
                : 'Survolez une zone');
        };

        info.addTo(mapL);

    }

    var geojson;
    var departementgeojson;
    var communegeojson;
    var codedep;

    // Listeners

    function highlightFeature(e) {
        var layer = e.target;

        layer.setStyle({
            weight: 5,
            color: '#666',
            dashArray: '',
            fillOpacity: 0.7
        });

        info.update(layer.feature.properties);

        if (!L.Browser.ie && !L.Browser.opera) {
            layer.bringToFront();
        }
    }

    function resetHighlight(e) {
        geojson.resetStyle(e.target);
        if(departementgeojson != null) {
            departementgeojson.resetStyle(e.target);
        }
        if(communegeojson != null) {
            communegeojson.resetStyle(e.target);
        }
        info.update();
    }

    function inLayer(layer, geo) {
        for (l in geo._layers) {
            if(geo._layers[l]===layer) {
                return true;
            }
        };
        return false;
    }

    function zoomToFeature(e) {
        mapL.fitBounds(e.target.getBounds());
        // Rajouter les départements
        var code = e.target.feature.properties.code;
        //console.log(e.target);
        //console.log(geojson);

        // Si je clique sur une region
        if(inLayer(e.target, geojson)) {
            clearCommune();
            // Si l'ancien layer departement existe, le supprimer
            if(mapL.hasLayer(departementgeojson)) {
                mapL.removeLayer(departementgeojson);
            }
            // Si l'ancien layer communes existe, le supprimer
            if(mapL.hasLayer(communegeojson)) {
                mapL.removeLayer(communegeojson);
            }
            // Rajouter le nouveau layer pour la region selectionnée
            $.getJSON( jsonBasePath+"regions/"+code+"/departements.geojson", function( data ) {
                enrichissementDepartements(data, function (d) {
                departementgeojson = L.geoJson(d,
                    {
                        style: style,
                        onEachFeature: onEachFeature
                     }).addTo(mapL);
                });
            });
        } else

        // Si je clique sur un département
        if(inLayer(e.target, departementgeojson)) {
            codedep = code;
            clearCommune();
            // Si l'ancien layer communes existe, le supprimer
            if(mapL.hasLayer(communegeojson)) {
                mapL.removeLayer(communegeojson);
            }
            // Rajouter le nouveau layer pour le département selectionné
            $.getJSON( jsonBasePath+"departements/"+code+"/communes.geojson", function( data ) {
                enrichissementCommunes(data, function (d) {
                communegeojson = L.geoJson(d,
                    {
                        style: style,
                        onEachFeature: onEachFeature
                     }).addTo(mapL);
                });
            });
        } else {
            // Je suis dans une commune
            displayCommune(e.target.feature.properties);
        }
    }

    function onEachFeature(feature, layer) {
        layer.on({
            mouseover: highlightFeature,
            mouseout: resetHighlight,
            click: zoomToFeature
        });
    }

    // Fin des listeners

    // Chargement du geojson au niveau région

    $(document).ready(function() {
        $('#searchForm').on('submit', function( e ) {
            e.preventDefault();
            refresh($('#search').val());
        });
 
        //refresh("pompes funebres");
        refresh("");
    });

    /// =======================   refresh pour une activité donnée

    function refresh(anActivite) {
        clearCommune();
        geojson = null;
        departementgeojson = null;
        communegeojson = null;
        codedep = null;
        activite = anActivite;
        //console.log(mapL);
        if(mapL != null) {
            mapL.remove();
        }
        mapL = L.map('map').setView([47.07, 2.37], 6);
        initMap();
        $.getJSON( jsonBasePath+"regions.geojson", function( data ) {
            enrichissementRegions(data, function (d) {
                geojson = L.geoJson(d,
                    {
                        style: style,
                        onEachFeature: onEachFeature
                     }).addTo(mapL);
            });
        });
    }


    /// ====================================== ENRICHISSEMENTS DONNEES =========================

    /// Les hooks d'enrichissement des données geojson
    /// Data représente les données GEOJSON à enrichir.
    /// callback est une fonction qui prend la data paramètre

    function enrichissementRegions(data, callback) {
        if(activite.length>0) {
            enrichissement(datapro+'region',data, callback);
        } else {
            mock(data,callback);
        }
    }

    function enrichissementDepartements(data, callback) {
        if(activite.length>0) {
            enrichissement(datapro+'departement',data, callback);
        } else {
            mock(data,callback);
        }
    }

    function enrichissementCommunes(data, callback) {
        if(activite.length>0) {
            enrichissement(datapro+'commune',data, callback);
        } else {
            mock(data,callback);
        }
    }

    function mock(data, callback) {
        var ponderation = activite.length > 0 ? (50-activite.length)/100:0;
        if(activite.length > 12) {
            ponderation = ponderation / 5;
        }
        data.features.forEach( function (o) {
            o.properties.ratio = (o.properties.nom.length / 100)*ponderation;
        });
        callback(data);
    }

    function enrichissement(apiratio, data, callback) {

        // Ici un exemple ou on enrichit le json avec
        // les données de population et le ratio pour la carte

        var nb = data.features.length;
        var current = 0;

        var finish = function() {
            current++;
            if(nb == current) {
                callback(data);
            }
        }
        
        data.features.forEach( function (o) {
            $.getJSON(apiratio,
                {
                    activite: activite,
                    ou: o.properties.code
                }, function(resultat) {
                //console.log(resultat);
                o.properties.ratio = Math.ceil(resultat.ratio*1000)/1000;
                //o.properties.ratio = (resultat.nbPro*1000.0)/resultat.population;
                o.properties.population = resultat.population;
                o.properties.nbPro = resultat.nbPro;
                finish();
            });
        });
    }

    /// ================================= FIN ENRICHISSEMENTS DONNEES =========================


    /// Affichage du cartouche de la commune

    function displayCommune(props) {
        console.log(props.nom);
        $('#commune').html(props.nom);
        $('#nbpro').find('.value').html(props.nbPro);
        $('#population .value').html(props.population);
        $('#densite .value').html(props.ratio);

        // Lien vers PJ LR
        var urlpjlr = 'http://www.pagesjaunes.fr/annuaire/'+props.nom+'-'+codedep+'/'+activite;
        $('#lr-pj').attr('href', urlpjlr);

        $('.area-result').show();
        //console.log("Afficher le cartouche de la commune");
    }

    function clearCommune() {
        $('.area-result').hide();
        //console.log("Nettoyer le cartouche de la commune");
    }