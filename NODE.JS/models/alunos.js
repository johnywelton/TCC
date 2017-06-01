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



const alunoModel  = {
    saveAluno : function(body,callback){
    connection = getConnection();
    connection.query('INSERT INTO aluno(nome,cpf,endereco,telefone,idcurso) VALUES (?,?,?,?,?)', [body.nome, body.cpf, body.endereco, body.telefone, body.curso], function (error, results, fields) {
        if (error){
            console.log('Erro na query ' + error);
        }else{
            callback(results);
        }
    });
    },
    selectAluno : function(body,callback){
    connection = getConnection();
    connection.query('select * from aluno', function (error, results, fields) {
        if (error){
            console.log('Erro na query ' + error);
        }else{
            callback(results);
        }
    });
    }    
}

module.exports = alunoModel