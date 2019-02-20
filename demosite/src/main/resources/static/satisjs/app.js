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
            id: 'URUN',
            label: 'Urun',
            type: 'string'
}, {
            id: 'ADET',
            label: 'Adet',
            type: 'integer',
}, {
            id: 'TARIH',
            label: 'Tarih',
            type: 'string'
}
]
};

    $('#builder').queryBuilder(options);
    $('#btn-getsatis').on('click',function () {
        var data = $('#builder').queryBuilder('getSQL');

        var form = $("<form method='post' action='/sorguyaGoreSatis' style='visibility: hidden;'></form>")
            .appendTo($("body"));

        form.append("<input name='sql' type='hidden' value='" + data.sql.toString().replaceAll("'", "|") + "' />");

        form.submit();
    });


});