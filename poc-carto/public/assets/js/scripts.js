function initSearchForms() {
    $('#aCompareForm').on('click', function(e){
        e.preventDefault();
        $('#searchForm').hide('slow');
        $('#compareForm').show('slow');
    });

    $('#aSearchForm').on('click', function(e){
        e.preventDefault();
        $('#compareForm').hide('slow');
        $('#searchForm').show('slow');
    });
}


// --------------------------------------------------------------------
$(document).ready(function() {
    initSearchForms();
});