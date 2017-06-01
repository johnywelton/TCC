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



const disciplinaModel  = {
    saveDisciplina : function(body,callback){
    connection = getConnection();
    connection.query('INSERT INTO disciplina(descricao,idcurso) VALUES (?,?)', [body.descricao, body.curso], function (error, results, fields) {
        if (error){
            console.log('Erro na query ' + error);
        }else{
            callback(results);
        }
    });
    },
    selectDisciplina : function(body,callback){
    connection = getConnection();
    connection.query('select * from disciplina', function (error, results, fields) {
        if (error){
            console.log('Erro na query ' + error);
        }else{
            callback(results);
        }
    });
    }   
}

module.exports = disciplinaModel