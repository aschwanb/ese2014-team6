/* Custom filtering function which will search data in column four between two values */
$.fn.dataTable.ext.search.push(
    function( settings, data, dataIndex ) {
        var min_price = parseInt( $('#min_price').val(), 10 );
        var max_price = parseInt( $('#max_price').val(), 10 );
        var min_room_size = parseInt( $('#min_room_size').val(), 10);
        var max_room_size = parseInt( $('#max_room_size').val(), 10);
        var price = parseFloat( data[3] ) || 0; // use data for the price column
        var room_size = parseFloat( data[4] ) || 0; // use data for the room size column
 
        if ( (( isNaN( min_price ) && isNaN( max_price ) ) ||
             ( isNaN( min_price ) && price <= max_price ) ||
             ( min_price <= price   && isNaN( max_price ) ) ||
             ( min_price <= price   && price <= max_price )) 
             &&
             (( isNaN( min_room_size ) && isNaN( max_room_size ) ) ||
             ( isNaN( min_room_size ) && room_size <= max_room_size ) ||
             ( min_room_size <= room_size   && isNaN( max_room_size ) ) ||
             ( min_room_size <= room_size   && room_size <= max_room_size )) )
        {
            return true;
        }
  
        return false;
    }
);
 
$(document).ready(function() {
    var table = $('#allAds').DataTable();
     
    // Event listener to the two range filtering inputs to redraw on input
    $('#min_price, #max_price, #min_room_size, #max_room_size').keyup( function() {
        table.draw();
    } );
} );