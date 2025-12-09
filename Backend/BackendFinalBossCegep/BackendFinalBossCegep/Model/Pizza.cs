using System.ComponentModel.DataAnnotations.Schema;

namespace BackendFinalBossCegep.Model
{
    [Table("pizza")]
    public class Pizza
    {
        [Column("id")]
        public int Id { get; set; }
        [Column("sorte")]
        public string Sorte { get; set; }
        
        [Column("prix_petite")]
        public float PrixPetite { get; set; }
        [Column("prix_moyenne")] 
        public float PrixMoyenne { get; set; }
        [Column("prix_grande")]
        public float PrixGrande { get; set; }

        [Column("image")]
        public int IdImage { get; set; }
    }
}
