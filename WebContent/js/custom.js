// JavaScript Document
$( ".datepicker" ).datepicker({
			inline: true,
			buttonImage: './images/date.png',
			buttonImageOnly: true,
			showOn: 'both',
});
$(document).ready(function() {
    var table = $('#example').DataTable( {
        lengthChange: false,
        buttons: [ 'copy', 'excel', 'pdf', 'colvis' ]
    } );
 
    table.buttons().container()
        .appendTo( '#example_wrapper .col-sm-6:eq(0)' );
} );