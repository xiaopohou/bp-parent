/**
 * Created by Administrator on 2017-11-17.
 */
$(function () {
    $('.js-data-example-ajax').select2({
        ajax: {
            url: '/api/user',
            dataType: 'json',
            // Additional AJAX parameters go here; see the end of this chapter for the full code of this example
            processResults: function (data) {
                // Tranforms the top-level key of the response object from 'items' to 'results'
                var d=[];
                for(var i=0;i<data.length;i++){
                    d.push({id:data[i].id,text:data[i].userName});
                }
                return {
                    results: d
                };
            }
        },
        minimumInputLength: 1
    });
});
