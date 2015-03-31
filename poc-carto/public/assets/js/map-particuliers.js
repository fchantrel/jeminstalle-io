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

var greenIcon = new LeafIcon({iconUrl: '../docs/images/leaf-green.png'}),
    redIcon = new LeafIcon({iconUrl: '../docs/images/leaf-red.png'}),
    orangeIcon = new LeafIcon({iconUrl: '../docs/images/leaf-orange.png'});

L.marker([51.5, -0.09], {icon: greenIcon}).bindPopup("I am a green leaf.").addTo(map);
L.marker([51.495, -0.083], {icon: redIcon}).bindPopup("I am a red leaf.").addTo(map);
L.marker([51.49, -0.1], {icon: orangeIcon}).bindPopup("I am an orange leaf.").addTo(map);
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

//------------------------------------------------------
// Chargement des données
// $(document).ready(function() {});