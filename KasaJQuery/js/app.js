$(document).ready(function () {
    var options ={
        allow_empty:true,

        filters:
[
{
            id: 'para',
            label: 'Para',
            type: 'integer'
}, 
{
    id: 'tarih',
    label: 'Tarih',
    type: 'string'
},
{
            id: 'guncelPara',
            label: 'Guncel Para',
            type: 'integer',
}
]
};

    $('#builder').queryBuilder(options);
    $('#builder').on('click',function () {
        console.log(JSON.stringify(
            $('#builder').queryBuilder('getSQL')
            //undefined,2
        ));

    });


});