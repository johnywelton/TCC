const mysql = require('mysql');
//const db_config = require('../config/dbconfig.json');

const db_config = {
  host     : 'localhost',
  user     : 'root',
  password : '1234',
  database : 'projetotcc'
};


let getConnection = function(){
    let connection = mysql.createConnection(db_config);
    connection.connect();
    return connection;
}


const closeConnection = function(connection){
    connection.end();
}



const cursoModel  = {
    saveCurso : function(body,callback){
    connection = getConnection();
    connection.query('INSERT INTO curso(descricao,turno) VALUES (?,?)', [body.descricao, body.turno], function (error, results, fields) {
        if (error){
            console.log('Erro na query ' + error);
        }else{
            callback(results);
        }
    });
    },
    selectCursos : function(body,callback){
    connection = getConnection();
    connection.query('select * from curso', function (error,results, fields) {
        if (error){
            console.log('Erro na query ' + error);
        }else{
            callback(results);
        }
    });
    }
}

module.exports = cursoModel
