namespace BackendFinalBossCegep.Model
{
    public class Compte
    {
        public int Id { get; set; }

        public string Email { get; set; } 

        public string Password { get; set; }

        public Compte(string email, string password) 
        {
            this.Email = email;
            this.Password = password;
        }
    }
}
