//------------------------------------------------------
// Définition du Centrage de la carte (FRANCE)
var map = L.map('map').setView([47.07, 2.37], 6);

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

function showMapIcon( lat, lng, sType, sEtabName )
{
    var LeafIcon = L.Icon.extend({
        options: {
            iconSize:     [32, 32],
            iconAnchor:   [22, 94],
            popupAnchor:  [-3, -76]
            //shadowUrl: '../docs/images/leaf-shadow.png',
            // shadowSize:   [32, 32],
            // shadowAnchor: [4, 62],
        }
    });

    switch( sType )
    {
        case 'boulangeries':
            sImage = 'boulangerie.png';
            break;
        case 'medecin':
            sImage = 'Medecin1.png';
            break;
        case 'pharmacies':
            sImage = 'pharmacie1.png';
            break;
        case 'ecoles':
            sImage = 'ecole.png';
            break;
        case 'bars':
            sImage = 'juice2.png';
            break;
        default :
            sImage = 'map-pointer7.png';
            break;

    }

    var jeminstalleIO_Icon = new LeafIcon({iconUrl: 'assets/img/'+sImage});

    // L.marker([lat, lng], {icon: jeminstalleIO_Icon}).addTo(map);
    L.marker([lat, lng], {icon: jeminstalleIO_Icon}).bindPopup(sEtabName).addTo(map);
}
//======================================================================================
function displayActivitePoi(  sActiviteLib, oDatasActivite )
{
    var aEtablissements = oDatasActivite.hits.hits;

    // console.log('aEtablissements : '+aEtablissements[0]._index);

    for(var i=0; i<aEtablissements.length; i++)
    {
        oEtab = aEtablissements[i];

        var sEtabName = oEtab._source.intlprincipal;
        var lat = oEtab._source.proGeoCoord.lat;
        var lon = oEtab._source.proGeoCoord.lon;
        console.log('sEtabName : '+sEtabName+' - lat : '+lat+' lon : '+lon+' - sActiviteLib : '+sActiviteLib);
        showMapIcon( lat, lon, sActiviteLib, sEtabName );
    }
}

//======================================================================================
// TOOL : fonction pour nettoyer le JSON malformé...
function _cleanJsonStringToObject( sJsonActivites ){

    var sOut = sJsonActivites.replace( /^(")/, "" );
        sOut = sJsonActivites.replace( /(")$/, "" );
        sOut = sJsonActivites.replace( /\\/, '' );

    return $.parseJSON( sOut );
}

//======================================================================================
// AFFICHAGE DES DONNEES SUR L'INTERFACE
function displayEnvironnement( oDatas )
{
    console.log( 'displayEnvironnement : '+oDatas );



    //Recentrage de la carte sur la localité choisie
    updateMap(  oDatas.refGeo );

    // Affichage des POI activités
    var aActivites = ['boulangeries', 'pharmacies', 'ecoles', 'bars'];
    for( var i in aActivites ){
        var strActivite = eval( 'oDatas.'+aActivites[i]);
        oDatasActivite = _cleanJsonStringToObject( strActivite );
        //Affichage des POI de l'activité
        displayActivitePoi(  aActivites[i], oDatasActivite );
    }

    //Affichage des infos de pollution
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
    });
}

//======================================================================================
// Chargement des données
$(document).ready(function() {
    initFormSearch();
});