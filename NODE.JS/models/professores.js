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



const professorModel  = {
    saveProfessor : function(body,callback){
    connection = getConnection();
    connection.query('INSERT INTO professor(nome,cpf,endereco,telefone) VALUES (?,?,?,?)', [body.nome, body.cpf, body.endereco, body.telefone], function (error, results, fields) {
        if (error){
            console.log('Erro na query ' + error);
        }else{
            callback(results);
        }
    });
    },
    selectProfessor : function(body,callback){
    connection = getConnection();
    connection.query('select * from professor', function (error, results, fields) {
        if (error){
            console.log('Erro na query ' + error);
        }else{
            callback(results);
        }
    });
    }      
}

module.exports = professorModel