using System.ComponentModel.DataAnnotations.Schema;

namespace BackendFinalBossCegep.Model
{
    [Table("utilisateur")]
    public class Compte
    {
        [Column("id")]
        public int Id { get; set; }

        [Column("email")]
        public string Email { get; set; }

        [Column("password")]
        public string Password { get; set; }

        [Column("name")]
        public string Name { get; set; }

        [Column("address")]
        public string Address { get; set; }

        [Column("phone")]
        public string Phone { get; set; }

        [Column("points")]
        public int Points { get; set; }

        public Compte(string email, string password, string name, string address, string phone) 
        {
            this.Email = email;
            this.Password = password;
            this.Name = name;
            this.Address = address;
            this.Phone = phone;
            this.Points = 0;
        }
    }
}