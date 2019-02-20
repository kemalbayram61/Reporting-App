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
            id: 'PARA',
            label: 'Para',
            type: 'integer'
}, 
{
    id: 'TARIH',
    label: 'Tarih',
    type: 'string'
},
{
            id: 'GUNCELPARA',
            label: 'Guncel Para',
            type: 'integer',
}
]
};

    $('#builder').queryBuilder(options);
    $('#btn-getkasa').on('click',function () {
        var data = $('#builder').queryBuilder('getSQL');

        var form = $("<form method='post' action='/sorguyaGoreKasa' style='visibility: hidden;'></form>")
            .appendTo($("body"));

        form.append("<input name='sql' type='hidden' value='" + data.sql.toString().replaceAll("'", "|") + "' />");


        form.submit();
    });


});