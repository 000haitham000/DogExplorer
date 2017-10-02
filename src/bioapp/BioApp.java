/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Haitham
 */
public class BioApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        String query = "select\n"
//                + "assoc.breed,\n"
//                + "assoc.var_type, \n"
//                + "#vcf_info.location, \n"
//                + "vcf_info.chrom, vcf_info.pos, vcf_info.id, vcf_info.ref, vcf_info.alt,\n"
//                + "assoc.f_a, assoc.f_u, assoc.fdr, assoc.aff_alt, assoc.aff_het, assoc.aff_ref, assoc.unaff_alt, assoc.unaff_het, assoc.unaff_ref,\n"
//                + "dog_ensembl.gene_name, \n"
//                + "var_effect.feature_name, var_effect.feature_type, var_effect.consequence, var_effect.cdna_position, var_effect.cds_position, var_effect.protein_position, var_effect.amino_acids, var_effect.codons, var_effect.extra,\n"
//                + "dog_ensembl.associated_gene_name, dog_ensembl.protein_coding, dog_ensembl.description\n"
//                + "from assoc, var_effect, vcf_info, dog_ensembl\n"
//                + "where\n"
//                + "assoc.location = var_effect.location and\n"
//                + "var_effect.location = vcf_info.location and \n"
//                + "var_effect.gene_name = dog_ensembl.gene_name;";
//        DB.getBioDBTableModel(query);
        new StartFrame().setVisible(true);
    }
}
