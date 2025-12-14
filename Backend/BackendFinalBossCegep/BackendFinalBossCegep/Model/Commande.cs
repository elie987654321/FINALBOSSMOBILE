using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Runtime.InteropServices;

namespace BackendFinalBossCegep.Model
{
    [Table("Commande")]
    public class Commande
    {
        [Key]
        [Column("numero_commande")]
        public int NumeroCommande { get; set; }
        [Column("nom_client")]
        public string NomClient { get; set; }
        [Column("montant")]
        public Decimal Montant { get; set; }
        [Column("date")]
        public DateTime Date { get; set; }
    }
}
