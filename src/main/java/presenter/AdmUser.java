package presenter;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.DataBaseMethods;
import model.Pokemon;
import model.Users;

public class AdmUser {
    
    public static void editUser() {
        Users u = null;
        String email = JOptionPane.showInputDialog(null, "Digite o email da conta que deseja alterar:");
        try {
            u = DataBaseMethods.findUserByEmail(email);
            JOptionPane.showConfirmDialog(null, "O usuario que deseja alterar:\n" + u.toString());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        String[] options = {"Name", "Email", "Password", "Type", "Age"};
        int atribute = JOptionPane.showOptionDialog(null, "Escolha o atributo a ser alterado:", "Altere o atributo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        String value = JOptionPane.showInputDialog(null, "Digite o valor novo:");
        switch(atribute) {
            case 0:
                String query = "UPDATE `pokemons`.`users` SET `name`='"+ value +"' WHERE (`id`='"+ u.getId() +"');";
                System.out.println(query);
                try {
                    DataBaseMethods.updateUser(query);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
            case 1:
                String query1 = "UPDATE `pokemons`.`users` SET `email`= '"+ value +"' WHERE ( `id` = '"+u.getId()+"');";
                try {
                    DataBaseMethods.updateUser(query1);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
            case 2:
                String query2 = "UPDATE `pokemons`.`users` SET `password` ='"+ value +"' WHERE ( `id` = '"+u.getId() +"');";
                try {
                    DataBaseMethods.updateUser(query2);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
            case 3:
                String query3 = "UPDATE `pokemons`.`users` SET `type` = '"+ value +"' WHERE ( `id` = '"+ u.getId() +"');";
                try {
                    DataBaseMethods.updateUser(query3);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
            case 4:
                String query4 = "UPDATE `pokemons`.`users` SET `age` = '"+ value +"' WHERE ( `id` = '"+ u.getId() + "');";
                try {
                    DataBaseMethods.updateUser(query4);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;     
        }
    }
    
    public static void deleteUser() {
        Users u = null;
        String email = JOptionPane.showInputDialog(null, "Digite o email da conta que deseja deletar:");
        
        try {
            u = DataBaseMethods.findUserByEmail(email);
            JOptionPane.showConfirmDialog(null, "O usuario que deseja deletar:\n" + u.toString());
        } catch (SQLException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Usuario não encontrado");
        }
        
        int conf = JOptionPane.showConfirmDialog(null, "Confirme o delete");
        if (conf == 0) {
            String query = "DELETE FROM `pokemons`.`users` WHERE (`id` = '"+ u.getId() +"');"; 
            DataBaseMethods.deleteUser(query);
        }else {
            JOptionPane.showMessageDialog(null, "Sem delete");
        }
    }
    
    public static void editPokemon() {
        Pokemon pokemon = null;
        String pokeName = JOptionPane.showInputDialog(null, "Digite o nome do Pokemon que deseja alterar:");
        String pokeName2 = pokeName.substring(0,1).toUpperCase();
        pokeName = pokeName2 + pokeName.substring(1); 
        DataBaseMethods a = new DataBaseMethods();
        try {
            pokemon = a.searchPokemon(pokeName);
            JOptionPane.showMessageDialog(null,"O pokemon que deseja alterar:\n"+ pokemon.toString());
        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "Pokemon não encontrado.");
            e1.printStackTrace();
        }
        String[] options = {"id", "Nome", "Tipo", "Habilidades", "HP", "Ataque", "Defesa", "Ataque E.", "Defesa E.", "Velocidade"};
        int atribute = JOptionPane.showOptionDialog(null, "Escolha o atributo a ser alterado:", "Altere o atributo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        String value = JOptionPane.showInputDialog(null, "Digite o valor novo:");
        switch(atribute) {
            case 0:
                try {
                    a.updatePokemon("id", value, Integer.toString(pokemon.getId()));
                    JOptionPane.showMessageDialog(null, "Atributo alterado com Sucesso!");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
            case 1:
                try {
                    a.updatePokemon("name", value, Integer.toString(pokemon.getId()));
                    JOptionPane.showMessageDialog(null, "Atributo alterado com Sucesso!");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
            case 2:
                try {
                    a.updatePokemon("type", value, Integer.toString(pokemon.getId()));
                    JOptionPane.showMessageDialog(null, "Atributo alterado com Sucesso!");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
            case 3:
                try {
                    a.updatePokemon("abilities", value, Integer.toString(pokemon.getId()));
                    JOptionPane.showMessageDialog(null, "Atributo alterado com Sucesso!");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
            case 4:
                try {
                    a.updatePokemon("hp", value, Integer.toString(pokemon.getId()));
                    JOptionPane.showMessageDialog(null, "Atributo alterado com Sucesso!");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
            case 5:
                try {
                    a.updatePokemon("att", value, Integer.toString(pokemon.getId()));
                    JOptionPane.showMessageDialog(null, "Atributo alterado com Sucesso!");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
            case 6:
                try {
                    a.updatePokemon("def", value, Integer.toString(pokemon.getId()));
                    JOptionPane.showMessageDialog(null, "Atributo alterado com Sucesso!");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;
            case 7:
                try {
                    a.updatePokemon("special_att", value, Integer.toString(pokemon.getId()));
                    JOptionPane.showMessageDialog(null, "Atributo alterado com Sucesso!");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                break;case 8:
                    try {
                        a.updatePokemon("special_def", value, Integer.toString(pokemon.getId()));
                        JOptionPane.showMessageDialog(null, "Atributo alterado com Sucesso!");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    break;
                case 9:
                    try {
                        a.updatePokemon("spd", value, Integer.toString(pokemon.getId()));
                        JOptionPane.showMessageDialog(null, "Atributo alterado com Sucesso!");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Atributo invalido");
                    break;
                
        }
    }
    
    public static void deletePokemon() {
        String pokeName = JOptionPane.showInputDialog(null, "Digite o nome do Pokemon que deseja excluir:");
        DataBaseMethods a = new DataBaseMethods();
        try {
            Pokemon pokemon = a.searchPokemon(pokeName);
            int i = JOptionPane.showConfirmDialog(null,"O pokemon que deseja excluir:\n"+ pokemon);
            if(i != 0) {
                JOptionPane.showMessageDialog(null, "Cancelado");
            }else {
                a.deletePokemon(pokemon.getId());
                JOptionPane.showMessageDialog(null, "Pokemon excluido com sucesso");
            }
        } catch (SQLException e1) {
            
            e1.printStackTrace();
        }
    }
}
