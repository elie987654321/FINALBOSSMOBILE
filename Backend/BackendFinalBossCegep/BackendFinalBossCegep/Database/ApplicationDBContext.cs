using BackendFinalBossCegep.Model;
using Microsoft.EntityFrameworkCore;

namespace BackendFinalBossCegep.Database
{
    public class ApplicationDBContext : DbContext
    {
        public ApplicationDBContext(DbContextOptions<ApplicationDBContext> options) : base (options)
        {
            
        }

        public DbSet<Compte> dbSetComptes { get; set; }
        public DbSet<Pizza> dbSetPizza { get; set; }
        public DbSet<Commande> dbSetCommande { get; set; }
    }
}
