var jsonBasePath = '../../';
var springhost = '192.168.160.227';
var datapro = 'http://'+springhost+':8080/datapro/';
var ACTIVITE = 'activite';
var OU = 'ou';

    //var map = L.map('map').setView([51.505, -0.09], 13);

    var map = L.map('map').setView([47.07, 2.37], 6);

    function getColor(d) {
        return d > 1 ? '#800026' :
            d > 0.5  ? '#BD0026' :
            d > 0.1  ? '#E31A1C' :
            d > 0.05  ? '#FC4E2A' :
            d > 0.01   ? '#FD8D3C' :
            d > 0.005   ? '#FEB24C' :
            d > 0.0001   ? '#FED976' :
                       '#FFEDA0';
    }

    function style(feature) {
        return {
            fillColor: getColor(feature.properties.ratio),
            weight: 2,
            opacity: 1,
            color: 'white',
            dashArray: '3',
            fillOpacity: 0.7
        };
    }

    // Controls

    var info = L.control();

    info.onAdd = function (map) {
        this._div = L.DomUtil.create('div', 'info'); // create a div with a class "info"
        this.update();
        return this._div;
    };

    // method that we will use to update the control based on feature properties passed
    info.update = function (props) {
        this._div.innerHTML = '<h4>Population de la zone</h4>' +  (props ?
            '<b>' + props.nom + '</b><br />' + props.population + '.'
            : 'Survolez une zone');
    };

    info.addTo(map);

    var geojson;
    var departementgeojson;
    var communegeojson;

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
        if(departementgeojson !='undefined') {
            departementgeojson.resetStyle(e.target);
        }
        if(communegeojson !='undefined') {
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
        map.fitBounds(e.target.getBounds());
        // Rajouter les départements
        var code = e.target.feature.properties.code;
        console.log(e.target);
        console.log(geojson);

        // Si je clique sur une region
        if(inLayer(e.target, geojson)) {
            // Si l'ancien layer departement existe, le supprimer
            if(map.hasLayer(departementgeojson)) {
                map.removeLayer(departementgeojson);
            }
            // Si l'ancien layer communes existe, le supprimer
            if(map.hasLayer(communegeojson)) {
                map.removeLayer(communegeojson);
            }
            // Rajouter le nouveau layer pour la region selectionnée
            $.getJSON( jsonBasePath+"regions/"+code+"/departements.geojson", function( data ) {
                enrichissementDepartements(data, function (d) {
                departementgeojson = L.geoJson(d,
                    {
                        style: style,
                        onEachFeature: onEachFeature
                     }).addTo(map);
                });
            });
        }

        // Si je clique sur un département
        if(inLayer(e.target, departementgeojson)) {
            // Si l'ancien layer communes existe, le supprimer
            if(map.hasLayer(communegeojson)) {
                map.removeLayer(communegeojson);
            }
            // Rajouter le nouveau layer pour le département selectionné
            $.getJSON( jsonBasePath+"departements/"+code+"/communes.geojson", function( data ) {
                enrichissementCommunes(data, function (d) {
                communegeojson = L.geoJson(d,
                    {
                        style: style,
                        onEachFeature: onEachFeature
                     }).addTo(map);
                });
            });
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

    // ===== Les layers du début ========

    // Fond de carte

    L.tileLayer('https://{s}.tiles.mapbox.com/v3/{id}/{z}/{x}/{y}.png', {
            maxZoom: 18,
            attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, ' +
                '<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
                'Imagery © <a href="http://mapbox.com">Mapbox</a>',
            id: 'examples.map-20v6611k'
        }).addTo(map);

    // Chargement du geojson au niveau région

    $(document).ready(function() {
        // console.log(jsonBasePath+"regions.geojson");
        $.getJSON( jsonBasePath+"regions.geojson", function( data ) {
            enrichissementRegions(data, function (d) {
                geojson = L.geoJson(d,
                    {
                        style: style,
                        onEachFeature: onEachFeature
                     }).addTo(map);
            });
        });
    });


    /// ====================================== ENRICHISSEMENTS DONNEES =========================

    /// Les hooks d'enrichissement des données geojson
    /// Data représente les données GEOJSON à enrichir.
    /// callback est une fonction qui prend la data paramètre

    function enrichissementRegions(data, callback) {
        enrichissement(data, callback);
    }

    function enrichissementDepartements(data, callback) {
        enrichissement(data, callback);
    }

    function enrichissementCommunes(data, callback) {
        enrichissement(data, callback);
    }

    function enrichissement(data, callback) {

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
            $.getJSON(datapro,
                {
                    activite: "pompe funebre",
                    ou: o.properties.code
                }, function(resultat) {
                console.log(resultat);
                o.properties.ratio = resultat.ratio;
                o.properties.population = resultat.population;
                finish();
            });
        });
    }

    /// ================================= FIN ENRICHISSEMENTS DONNEES =========================