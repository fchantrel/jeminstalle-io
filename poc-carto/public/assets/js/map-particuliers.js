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
            iconSize:     [16, 16],
            iconAnchor:   [8, 8],
            popupAnchor:  [0, -8]
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
            sImage = 'pharmacie.png';
            break;
        case 'ecoles':
            sImage = 'ecole.png';
            break;
        case 'transports':
            sImage = 'bus.png';
            break;
        case 'bars':
            sImage = 'juice2.png';
            break;
        default :
            sImage = 'map-pointer-yellow.png';
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

    var iNbEtablissements = aEtablissements.length;
    // console.log('aEtablissements : '+aEtablissements[0]._index);
    if( 'boulangeries' == sActiviteLib  || 'bars' == sActiviteLib )
    {
        $("#"+sActiviteLib).find('span.value').html( ' : '+iNbEtablissements+' établissement(s)' );
    }

    for(var i=0; i<iNbEtablissements; i++)
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
function displayTransportsPoi( aDatasTransports )
{

    for(var i=0; i<aDatasTransports.length; i++)
    {
        oArret = aDatasTransports[i];
        var sNomArret = oArret.nom+' - '+oArret.ligne;
        var lat = oArret.location.lat;
        var lon = oArret.location.lon;
        console.log('sEtabName : '+sNomArret+' - lat : '+lat+' lon : '+lon+' - sActiviteLib : Transports');

        showMapIcon( lat, lon, 'transports', sNomArret );
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
    //console.log( 'displayEnvironnement : '+oDatas );

    // on supprime les span rating
    $("span").remove(".rating");

    //Recentrage de la carte sur la localité choisie
    updateMap(  oDatas.refGeo );

    // Affichage des POI activités
    var aActivites = ['boulangeries', 'pharmacies', 'ecoles', 'bars'];
    for( var i in aActivites ){
        var strActivite = eval( 'oDatas.'+aActivites[i]);
        oDatasActivite = _cleanJsonStringToObject( strActivite );
        //Affichage des POI de l'activité
        if( 'undefined' != typeof(oDatasActivite) ){
            displayActivitePoi(  aActivites[i], oDatasActivite );
        }
    }

    if( 'undefined' != typeof(oDatas.starbuses) ){
        displayTransportsPoi( oDatas.starbuses );
    }


    //Affichage des infos de pollution
    if( 'undefined' != typeof(oDatas.pollution) ){
        displayPollution(  oDatas.pollution );
    }

    //Affichage des infos de couverture4G
    if( 'undefined' != typeof(oDatas.couverture4G) ){
        displayCouverture4G(  oDatas.couverture4G );
    }

    //Affichage des infos de Revenu Moyen
    if( 'undefined' != typeof(oDatas.revenuMoyen) ){
        displayRevenuMoyen(  oDatas.revenuMoyen );
    }

    //Affichage des infos de Précipitations
    if( 'undefined' != typeof(oDatas.precipitation) ){
        displayPrecipitation(  oDatas.precipitation );
    }

    //Affichage des infos d'Ensoleillement
    if( 'undefined' != typeof(oDatas.ensoleillement) ){
        displayEnsoleillement(  oDatas.ensoleillement );
    }

    //Affichage des infos de Nucléaire
    if( 'undefined' != typeof(oDatas.nucleaire) ){
        displayNucleaire(  oDatas.nucleaire );
    }
}

// Recentrage de la carte
function updateMap(  oRefGeo ){
    var lat = oRefGeo.latitude; //": 48.114723,
    var lng = oRefGeo.longitude; //": -1.679444,
    console.log( 'lat : '+lat+' - lng : '+lng );
    return map.setView([lat, lng], 13);
}

function insertRating( sJqSelector ){
    console.log( sJqSelector );
    // ne semble pas fonctionner
    $(sJqSelector).remove(".rating");
    $( '<span class="rating"><span></span></span>' ).appendTo( sJqSelector );
}


// Affichage du nombre de sites pollués
function displayPollution(   oDatasPollution ) {
    var iClassmt = oDatasPollution.classement;
    var sNiveau = 'niveau-'+ Math.ceil( (100-iClassmt)/20 );
    $("#nbSitesPollues")
        .attr("class", sNiveau )
        .find('span.value').html( ' : '+oDatasPollution.nbsitespolues );
    insertRating( "#nbSitesPollues" );
}


//Affichage des infos de couverture4G
function displayCouverture4G(  oDatasCouverture4G )
{
    $("#orange").find('span.value').html(' : '+ (oDatasCouverture4G.couvorange*100) +'%');
    $("#sfr").find('span.value').html(' : '+ (oDatasCouverture4G.couvsfr*100) +'%');
    $("#free").find('span.value').html(' : '+ (oDatasCouverture4G.couvfree*100) +'%');
    $("#bouygues").find('span.value').html(' : '+ (oDatasCouverture4G.couvbouygues*100) +'%');
}

//Affichage des infos de Revenu Moyen
function displayRevenuMoyen(  oDatasRevenuMoyen )
{
    var iNbCommunesEnFrance = 36552;
    var iClassmt = oDatasRevenuMoyen.classement;
    var sNiveau = 'niveau-'+ Math.ceil( (iClassmt/iNbCommunesEnFrance)*5 );
    $("#revenuMoyen")
        .attr("class", sNiveau )
        .find('span.value').html( ' : '+oDatasRevenuMoyen.revenu+' &euro;/an' );
    insertRating( "#revenuMoyen" );
}

//Affichage des infos de Précipitations
function displayPrecipitation(  oDatasPrecipitation )
{
    var iNbDepEnFrance = 101;
    var iClassmt = oDatasPrecipitation.classement;
    var sNiveau = 'niveau-'+ Math.ceil( ( (iNbDepEnFrance-iClassmt)/iNbDepEnFrance)*5 );
    $("#pluviometrie")
        .attr("class", sNiveau )
        .find('span.value').html( ' : '+oDatasPrecipitation.precipitation+' mm/an' );
    insertRating( "#pluviometrie" );
}
//Affichage des infos de Précipitations
function displayEnsoleillement(  oDatasEnsoleillement )
{
    var iNbDepEnFrance = 101;
    var iClassmt = oDatasEnsoleillement.classement;
    var sNiveau = 'niveau-'+ Math.ceil( ( (iNbDepEnFrance-iClassmt)/iNbDepEnFrance)*5 );
    var iEnsoleillement = ( oDatasEnsoleillement.ensoleillement / 12 );
    $("#ensoleillement")
        .attr("class", sNiveau )
        .find('span.value').html( ' : '+iEnsoleillement+' j/an' );
    insertRating( "#ensoleillement" );
}

//Affichage des infos de Nucléaire
function displayNucleaire(  oDatasNucleaire )
{
    $("#nbCentrales")
        .find('span.value').html( ' : '+oDatasNucleaire.nbcentrale+' centrale(s) dans le département.' );
}

//======================================================================================
// Formulaire de recherche
function initFormSearch(){
    $("#searchForm").on('submit', function(e){

        e.preventDefault();
        var sVille = $('#search').val();
        //var sVille = 'rennes';//on triche !
        //var sBaseUrl = 'http://192.168.161.62:8080/dataparticulier/ville/';
        var sBaseUrl = 'http://localhost:8080/dataparticulier/ville/';

        $.getJSON( sBaseUrl+sVille, function( data ) {
            displayEnvironnement(data);
        });

        // $.getJSON( "../../../dataparticulier_ville_"+sVille+".json", function( data ) {
        //     displayEnvironnement(data);
        // });
    });
}

//======================================================================================
// Chargement des données
$(document).ready(function() {
    initFormSearch();
});