$(document).ready(function () {
    var options ={
        allow_empty:true,

        filters: 
[
{
            id: 'adi',
            label: 'Adi',
            type: 'string'
}, {
            id: 'adet',
            label: 'Adet',
            type: 'integer',
}, {
            id: 'fiyat',
            label: 'Fiyat',
            type: 'integer',
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