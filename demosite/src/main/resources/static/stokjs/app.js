String.prototype.replaceAll = function(search, replacement) {
    var target = this;
    return target.split(search).join(replacement);
};
$(document).ready(function () {
    var options ={
        allow_empty:true,

        filters: 
[
{
            id: 'ADI',
            label: 'Adi',
            type: 'string'
}, {
            id: 'ADET',
            label: 'Adet',
            type: 'integer',
}, {
            id: 'FIYAT',
            label: 'Fiyat',
            type: 'integer',
}
]
};


    $('#builder').queryBuilder(options);
    $('#btn-getstok').on('click',function () {
        var data = $('#builder').queryBuilder('getSQL');

        var form = $("<form method='post' action='/sorguyaGoreStok' style='visibility: hidden;'></form>")
            .appendTo($("body"));

        form.append("<input name='sql' type='hidden' value='" + data.sql.toString().replaceAll("'", "|") + "' />");


        form.submit();
    });

});