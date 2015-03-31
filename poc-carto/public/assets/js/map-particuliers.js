var map = L.map('map').setView([47.07, 2.37], 6);

//------------------------------------------------------
// Définition des ICONES
var LeafIcon = L.Icon.extend({
    options: {
        shadowUrl: '../docs/images/leaf-shadow.png',
        iconSize:     [38, 95],
        shadowSize:   [50, 64],
        iconAnchor:   [22, 94],
        shadowAnchor: [4, 62],
        popupAnchor:  [-3, -76]
    }
});

// var greenIcon = new LeafIcon({iconUrl: '../docs/images/leaf-green.png'}),
    // redIcon = new LeafIcon({iconUrl: '../docs/images/leaf-red.png'}),
    // orangeIcon = new LeafIcon({iconUrl: '../docs/images/leaf-orange.png'});

// L.marker([47.02, 2.3], {icon: greenIcon}).bindPopup("I am a green leaf.").addTo(map);
// L.marker([47.08, 2.47], {icon: redIcon}).bindPopup("I am a red leaf.").addTo(map);
// L.marker([47.18, 2.27], {icon: orangeIcon}).bindPopup("I am an orange leaf.").addTo(map);
//------------------------------------------------------



//------------------------------------------------------
// Définition du FOND DE CARTE
L.tileLayer('https://{s}.tiles.mapbox.com/v3/{id}/{z}/{x}/{y}.png', {
        maxZoom: 18,
        attribution: 'Map data &copy; <a href="http://openstreetmap.org">OpenStreetMap</a> contributors, ' +
            '<a href="http://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, ' +
            'Imagery © <a href="http://mapbox.com">Mapbox</a>',
        id: 'examples.map-20v6611k'
    }).addTo(map);

//======================================================================================

function showMapIcon( lat, lng, sType )
{
    var LeafIcon = L.Icon.extend({
        options: {
            // shadowUrl: '../docs/images/leaf-shadow.png',
            iconSize:     [32, 32],
            shadowSize:   [32, 32],
            // iconAnchor:   [22, 94],
            // shadowAnchor: [4, 62],
            popupAnchor:  [-3, -76]
        }
    });

    switch( sType )
    {
        case 'boulangerie':
            sImage = 'boulangerie.png';
            break;
        case 'medecin':
            sImage = 'Medecin1.png';
            break;
        case 'pharmacie':
            sImage = 'pharmacie1.png';
            break;
        case 'ecole':
            sImage = 'ecole.png';
            break;
        case 'bar':
            sImage = 'ecole.png';
            break;

    }

    var jeminstalleIO_Icon = new LeafIcon({iconUrl: '../docs/img/'+sImage}),

    L.marker([lat, lng], {icon: jeminstalleIO_Icon})
        .addTo(map);
        // .bindPopup("I am a green leaf.")
}

//======================================================================================
// AFFICHAGE DES DONNEES SUR L'INTERFACE
function displayEnvironnement( oDatas )
{
    console.log( 'displayEnvironnement : '+oDatas );

    //Recentrage de la carte sur la localité choisie
    updateMap(  oDatas.refGeo );

    //Recentrage de la carte sur la localité choisie
    displayPollution(  oDatas.pollution );

}

// Recentrage de la carte
function updateMap(  oRefGeo ){
    var lat = oRefGeo.latitude; //": 48.114723,
    var lng = oRefGeo.longitude; //": -1.679444,
    console.log( 'lat : '+lat+' - lng : '+lng );
    return map.setView([lat, lng], 13);
}

// Affichage du nombre de sites pollués
function displayPollution(   oDatasPollution ) {
    var iClassmt = oDatasPollution.classement;
    var sNiveau = 'niveau-'+ Math.ceil( iClassmt/20 );
    $("#nbSitesPollues")
        .attr("class", sNiveau )
        .find('span.value').html( ' : '+oDatasPollution.nbsitespolues );
}

//======================================================================================
// Formulaire de recherche
function initFormSearch(){
    $("#searchForm").on('submit', function(e){

        e.preventDefault();
        // var sVille = $('#search').val();
        var sVille = 'rennes';//on triche !
        $.getJSON( "../../../dataparticulier_ville_"+sVille+".json", function( data ) {
            displayEnvironnement(data);
        });
    })
}

//======================================================================================
// Chargement des données
$(document).ready(function() {
    initFormSearch();
});