import {http} from './config'

export default {
    //buscar os dados na api
    listar: () => {
        return http.get('produtos')
    },

    //salvar 
    salvar: (produto)=>{
        return http.post('produto', produto)
    },
 
    //editar
    editar: (produto) =>{
        return http.put('produto', produto)
    },

    //deletar
    deletar: (produto) =>{
        return http.delete('produto', {data: produto})
    }


}