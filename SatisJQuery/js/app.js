$(document).ready(function () {
    var options ={
        allow_empty:true,

        filters: 
[
{
            id: 'urun',
            label: 'Ürun',
            type: 'string'
}, {
            id: 'adet',
            label: 'Adet',
            type: 'integer',
}, {
            id: 'tarih',
            label: 'Tarih',
            type: 'string'
}
]
};

    $('#builder').queryBuilder(options);
    $('#builder').on('click',function () {
        console.log(JSON.stringify(
            $('#builder').queryBuilder('getSQL'),
            undefined,2
        ));

    });


});